from django.shortcuts import render_to_response
from twitter.models import Friend
import twitter_access

tw = twitter_access.twitter_access()

def last_tweets(request, tweet_id):
    statuses = tw.get_last_tweets(10)
    return render_to_response('twitter/tweet.html',
        {'tweet_id': tweet_id,
         'statuses': statuses})

def refresh(request, user_id):
    friends_from_api = tw.get_all_friends(user_id)
    for friend_from_api in friends_from_api:
        try:
            friend = Friend.objects.get(pk=friend_from_api.id)
        except Friend.DoesNotExist:
            friend = Friend(pk=friend_from_api.id)
        friend.active = True
        friend.screen_name = friend_from_api.screen_name
        friend.followed_by = friend_from_api.followers_count
        friend.follows = friend_from_api.friends_count
        friend.save()

    return render_to_response('twitter/refreshed.html',
        {'count': len(friends_from_api)})


