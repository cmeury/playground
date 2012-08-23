from django.conf.urls import patterns, include, url, handler404
from django.contrib import admin

admin.autodiscover()

urlpatterns = patterns('',
    url(r'^admin/doc/', include('django.contrib.admindocs.urls')),
    url(r'^admin/', include(admin.site.urls)),

    url(r'^polls/', include('polls.urls')),
    url(r'^twitter/', include('twitter.urls')),
)
