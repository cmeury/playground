import tweepy

class twitter_access(object):

    def __init__(self):

        # == OAuth Authentication ==
        #
        # This mode of authentication is the new preferred way
        # of authenticating with Twitter.

        # The consumer keys can be found on your application's Details
        # page located at https://dev.twitter.com/apps (under "OAuth settings")
        consumer_key="QDxWKKQDIltdVMYyMufgSg"
        consumer_secret="Ec2SkfxRN2pcjC1nensCen9HRjikoCuQTOOMV0bUY"

        # The access tokens can be found on your applications's Details
        # page located at https://dev.twitter.com/apps (located
        # under "Your access token")
        access_token="35724043-Kcx9g2buXouOUFCTX7LrzQBl9erfkQHpMBNinW02s "
        access_token_secret="l7l8ZycOjsRdHa2mw3Anzszje4jXKwT0Gq1tmDmajOA"

        auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
        auth.set_access_token(access_token, access_token_secret)
        self.api = tweepy.API(auth)

    def get_last_tweets(self, count):
        return tweepy.Cursor(self.api.home_timeline).items(count)

    def get_all_friends(self, user_id):
        return self.api.friends(user_id)
