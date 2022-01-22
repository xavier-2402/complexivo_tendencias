from django.shortcuts import render
from rest_framework.decorators import api_view
from django.http.response import JsonResponse
from rest_framework.parsers import JSONParser
from rest_framework import status
from .models import Comentario, Comment
from .serializers import ComentarioSerializer, CommentSerializer

# Create your views here.

@api_view(['GET','POST'])
def comentarios(request):
    if request.method =='GET':
        comentarios=Comentario.objects.all()
        comentarios_serializer= ComentarioSerializer(comentarios,many=True)
        return JsonResponse(comentarios_serializer.data,safe=False)
    elif request.method =='POST':
        comentario_data=JSONParser().parse(request)
        comentario_serializer= ComentarioSerializer(data=comentario_data)
        if comentario_serializer.is_valid():
            comentario_serializer.save()
            return JsonResponse(comentario_serializer.data,status=status.HTTP_201_CREATED)
        return JsonResponse(comentario_serializer.errors,status=status.HTTP_400_BAD_REQUEST)
        

@api_view(['GET','POST'])
def comment(request):
    if request.method =='GET':
        comment=Comment.objects.all()
        comment_serializer= CommentSerializer(comment,many=True)
        return JsonResponse(comment_serializer.data,safe=False)
    elif request.method =='POST':
        comment_data=JSONParser().parse(request)
        comment_serializer= ComentarioSerializer(data=comment_data)
        if comment_serializer.is_valid():
            comment_serializer.save()
            return JsonResponse(comment_serializer.data,status=status.HTTP_201_CREATED)
        return JsonResponse(comment_serializer.errors,status=status.HTTP_400_BAD_REQUEST)      
        
 
 
@api_view(['GET'])
def detalle_comentarios(request,pk):
    try:   
        comntario = Comentario.objects.get(pk=pk)
    except Comentario.DoesNotExist:
        return JsonResponse({'mensaje':"El comentario solicitado no existe",
                             'status':status.HTTP_404_NOT_FOUND})
        