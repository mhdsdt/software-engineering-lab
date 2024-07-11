from django.shortcuts import render
from django.http import HttpResponse
from django.shortcuts import render
from .models import Post

def home(request):
    context ={'posts': Post.objects.all()}
    # return HttpResponse('<h1>Blog Home</h1>')
    return render(request, "blog/home.html", context)

def about(request):
    context = {'title': 'About'}
    return render(request, "blog/about.html", context)


# Create your views here.
