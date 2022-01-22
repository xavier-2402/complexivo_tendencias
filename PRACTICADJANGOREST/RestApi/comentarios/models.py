#from django.db import models
from djongo import models

# Create your models here.

class Usuario(models.Model):
    username=models.CharField(max_length=20,blank=False,default='')
    puede_comentar =models.BooleanField(default=True)
    nombre=models.CharField(max_length=100,blank=False,default='')
    

class Comentario(models.Model):
    texto_comentario = models.CharField(max_length=1000,blank=False,default='')
    fecha_publicacion = models.DateField('fecha publicacion')
    publicado = models.BooleanField(default=False)
    usuario=models.ForeignKey(Usuario,on_delete=models.SET_NULL,null=True)
    
    
class Comment(models.Model):
    texto_comentario = models.CharField(max_length=1000,blank=False,default='')
    fecha_publicacion = models.DateField('fecha publicacion')
    publicado = models.BooleanField(default=False)
   
    
