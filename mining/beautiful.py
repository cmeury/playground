# -*- coding: utf-8 -*-

import sys
import re
import urllib2
import json
import HTMLParser
from BeautifulSoup import BeautifulSoup

url = sys.argv[1]

def parse_hreviews(url):
    try:
        page = urllib2.urlopen(url)
    except urllib2.URLError, e:
        print 'Failed to fetch ' + url
        raise e

    try:
        soup = BeautifulSoup(page)
    except HTMLParser.HTMLParseError, e:
        print 'Failed to parse ' + url
        raise e

    links = soup.findAll(True, 'a')

    all_links = []
    for link in links:
        if link and len(link) > 4:
            url = link['href']
            title = link.text  

            all_links.append({
                 'title': title,
                 'href': href,
            })
    return all_links

reviews = parse_hreviews(url)

print json.dumps(reviews, indent=4)
