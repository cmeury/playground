import twitter
import json
import sys
import cPickle
from twitter.oauth_dance import oauth_dance
# import keys from file which is excluded from git via .gitignore
from secret import *

screen_name = 'DerCed'
friends_limit = 5000

print "Retrieving OAuth token..."
(oauth_token, oauth_token_secret) = oauth_dance('MiningTheSocialWeb', consumer_key, consumer_secret)
print "Accessing Twitter using the retrieved token..."
t = twitter.Twitter(domain='api.twitter.com', api_version='1', auth=twitter.oauth.OAuth(oauth_token, oauth_token_secret, consumer_key, consumer_secret))

print "Start paging..."
ids = []
wait_period = 2 # secs
cursor = -1

while cursor != 0:
	if wait_period > 3600: # 1 hour
		print 'Too many retries. Saving partial data to disk and exiting.'
		f = file('%s.friend_ids' % str(cursors, 'wb'))
		cPickle.dump(ids, f)
		f.close()
		exit()

	try:
		response = t.friends.ids(screen_name=screen_name, cursors=cursor)
		ids.extend(response['ids'])
		wait_period = 2
	except twitter.api.TwitterHTTPError, e:
		if e.e.code == 401:
			print 'Encountered 401 Error (Not Authorized)'
			print 'User %s is protecting their tweets.' % (screen_name,)
		elif e.e.code in (502,503):
			print 'Encountered %i Error. Trying again in %i seconds.' % (e.e.code, wait_period)
			time.sleep(wait_period)
			wait_period *= 1.5
			continue
		elif t.account.rate_limit_status()['remaining_hits'] == 0:
			status = t.account.rate_limit_status()
			now = time.time() # UTC
			when_rate_limit_resets = status['reset_time_in_seconds'] # UTC
			sleep_time = when_rate_limit_resets - now
			print 'Rate limit reached. Trying in %i seconds.' % (sleep_time, )
			time.sleep(sleep_time)
			continue

	cursor = response['next_cursor']
	print 'Fetched %i ids for %s' % (len(ids), screen_name)
	if len(ids) >= friends_limit:
		break

# do something with IDs

print ids

