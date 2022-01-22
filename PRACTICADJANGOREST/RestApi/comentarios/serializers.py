from rest_framework import serializers
from .models import Comentario, Comment,Usuario

class ComentarioSerializer(serializers.ModelSerializer):
    class Meta:
        model=Comentario
        fields=(
            'id',
            'texto_comentario',
            'fecha_publicacion',
            'usuario'
        )
        
class UsuarioSerializer(serializers.ModelSerializer):
    class Meta:
        model=Usuario
        fields=(
            'id',
            'username',
            'nombre',
        )

class CommentSerializer(serializers.ModelSerializer):
    class Meta:
        model=Comment
        fields=(
            'id',
            'texto_comentario',
            'fecha_publicacion',
        )