FROM python:3.10.5-slim-buster

ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1

WORKDIR /app

# Install PostgreSQL development libraries
RUN apt-get update && apt-get install -y libpq-dev gcc

COPY requirements.txt ./
RUN pip install --upgrade pip && pip install -r requirements.txt

COPY . /app

EXPOSE 8000

CMD python manage.py migrate && python manage.py runserver 0.0.0.0:8000
