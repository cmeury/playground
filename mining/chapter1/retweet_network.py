#import nltk
import cPickle
import re
import networkx as nx


class Grapher:

    g = nx.DiGraph()

    def get_rt_sources(self, tweet):
        rt_patterns = re.compile(r"(RT|via)((?:\b\W*@\w+)+)", re.IGNORECASE | re.UNICODE)
        return [ source.strip() for tuple in rt_patterns.findall(tweet) for source in tuple if source not in ("RT", "via")]

    def __init__(self):
        all_tweets = cPickle.load(open("tweets.pickle"))
        for tweet in all_tweets:
            rt_sources = self.get_rt_sources(tweet["text"])
            if not rt_sources: continue
            for rt_source in rt_sources:
                self.g.add_edge(rt_source, tweet["from_user"], {"tweet_id": tweet["id"]})

    def get_graph(self):
        return self.g
