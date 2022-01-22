from django.db import models

# Create your models here.

class Question(models.Model):
    Question_text=models.CharField(max_length=300)
    pub_date = models.DateTimerField('date published')
    
class Choice(models Model):
    question = models.ForeignKey(Question)