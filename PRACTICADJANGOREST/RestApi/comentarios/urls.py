from django.conf.urls import url
from comentarios import views

urlpatterns = [
    url('',views.comentarios),
    url(r'^api/comentarios$/<pk>',views.comentarios),
    url('',views.comment),
    
]
