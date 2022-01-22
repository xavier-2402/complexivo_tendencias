from django.shortcuts import render
from django.http import HttpResponse
from .models import Question

# Create your views here.


def index(request):
    listado_ultimas_preguntas = Question.objects.order_by('.pub_date')[:5]
    salida=', '.join([q.question_text for q in listado_ultimas_preguntas])
    return HttpResponse('Bienvenido a la aplicación Poll')
def detail(request,question_id):
    return HttpResponse(f"Usted está consultando la pregunta {question_id}")
    
def results(request,question_id):
   return HttpResponse(f"Estos son los resultados de la pregunta {question_id}")
    
def vote(request,question_id):
     return HttpResponse(f"Usted ha votado en la pregunta {question_id}")