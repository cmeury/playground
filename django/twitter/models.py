from django.db import models

class Friend(models.Model):
    id = models.BigIntegerField(primary_key=True)
    screen_name = models.CharField(max_length=15)
    follows = models.IntegerField()
    followed_by = models.IntegerField()
    last_updated = models.DateTimeField(auto_now=True, auto_now_add=True)
    active = models.BooleanField()
