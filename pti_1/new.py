#!/usr/bin/python
# -*- encoding: utf-8 -*-

# Llibreries
import cgi, os, re, sys, string, time, csv

# Programa principal
print "Content-type: text/html\n\n"

c = csv.writer(open("car.csv","a"))
form = cgi.FieldStorage()
model_vehicle = form.getvalue('model_vehicle')
if model_vehicle == 54:
	 model_vehicle = "Econòmic"
elif model_vehicle == 71: 
	model_vehicle = "Semi-luxe"
elif model_vehicle == 82:
	 model_vehicle = "Luxe"
elif model_vehicle == 139:
	 model_vehicle = "Limusina"
engine = form.getvalue('sub_model_vehicle')
days = form.getvalue('dies_lloguer')
units = form.getvalue('num_vehicles')
des = form.getvalue('descompte')

c.writerow([model_vehicle,engine,days,units,des])


