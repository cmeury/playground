from django.conf.urls import patterns, url

from django.contrib import admin

admin.autodiscover()

urlpatterns = patterns('',
    url(r'^(?P<tweet_id>\d+)/$','twitter.views.last_tweets'),
    url(r'^(?P<user_id>\w+)/refresh/$','twitter.views.refresh')

)
