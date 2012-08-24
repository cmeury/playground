import twitter
import json
import sys
import cPickle
from twitter__login import login
from twitter__util import makeTwitterRequest

t = login()

def getFriendIds(screen_name=None, user_id=None, friends_limit=5000):
	assert screen_name is not None or user_id is not None

	ids = []
	cursor = -1

	while cursor != 0:
		params = dict(cursor=cursor)
		if screen_name is not None:
			params['screen_name'] = screen_name
		else:
			params['user_id'] = user_id

		response = makeTwitterRequest(t, t.friends.ids, **params)
		ids.extend(response['ids'])
		cursor = response['next_cursor']
		print >> sys.stderr, 'Fetched %i ids for %s' % (len(ids), screen_name or user_id)
		if len(ids) >= friends_limit:
			break

	return ids

if __name__ == '__main__':
	if len(sys.argv) != 2:
		print 'usage: python twittergraph.py <SCREEN_NAME>'
		sys.exit()
	ids = getFriendIds(sys.argv[1], friends_limit=500)
	print ids

