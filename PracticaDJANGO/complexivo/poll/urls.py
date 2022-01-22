from django.urls import path

from . import views


urlpatterns = [
    path('', views.index,name="index"),
    #path('', views.saludo,name="saludo"),
    path('<int:question_id>', views.detail,name="detail"),
    path('<int:question_id>', views.results,name="results"),
    path('<int:question_id>', views.vote,name="vote")
]