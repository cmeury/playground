import twitter
import json

# import keys from file which is excluded from git via .gitignore
from secret import *

screen_name = 'DerCed'
t = twitter.Twitter(domain='api.twitter.com', api_version='1')
response = t.users.show(screen_name=screen_name)
print json.dumps(response, sort_keys=True, indent=4)
