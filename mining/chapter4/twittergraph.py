import twitter
import json
import secret

print access_token
screen_name = 'DerCed'

t = twitter.Twitter(domain='api.twitter.com', api_version='1')
response = t.users.show(screen_name=screen_name)
print json.dumps(response, sort_keys=True, indent=4)
