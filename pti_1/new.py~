#! /usr/bin/python

# Llibreries
import cgi, os, re, sys, string, time, csv

# Programa principal
print "Content-type: text/html\n\n"
c = csv.writer(open("car.csv","wb"))
form = cgi.FieldStorage()
model = form.getvalue('model_vehicle')
engine = form.getvalue('sub_model_vehicle')
days = form.getvalue('dies_lloguer')
units = form.getvalue('num_vehicles')
des = form.getvalue('descompte')



c.writerow([model,engine,days,units,des])

