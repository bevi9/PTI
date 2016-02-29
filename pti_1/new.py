#!/usr/bin/python
# -*- encoding: utf-8 -*-

# Llibreries
import cgi, os, re, sys, string, time, csv

# Programa principal
print "Content-type: text/html\n\n"

form = cgi.FieldStorage()
model_vehicle = form.getvalue('model_vehicle')
if model_vehicle == "54":
	model_vehicle = "Economic"
	cost = 10 
elif model_vehicle == "71": 
	model_vehicle = "Semi-luxe"
	cost = 20
elif model_vehicle == "82":
	model_vehicle = "Luxe"
	cost = 30
elif model_vehicle == "139":
	model_vehicle = "Limusina"
	cost = 40

home = "http://localhost/p1/carrental_home.html"
new = "http://localhost/p1/carrental_form_new.html"

engine = form.getvalue('sub_model_vehicle')
try:
	days = int(form.getvalue('dies_lloguer'))
	units = int(form.getvalue('num_vehicles'))
	des = float(form.getvalue('descompte'))
except:
    print '<html>'
    print ' <body>'
    print "  <h1>T'ha faltat intruduir parametres</h1>"
    print ' <head>'
    print '  <a href="%s">Tornar a introduir el cotxe</a>' % new
    print ' </head>'
    print '</body>'
    print '</html>'

ok = 0
if des == 0.0 or des == 1.0:
    ok = 1

if days <= 0 or des <= 0 or units <= 0 or ((des).is_integer() or des > 1) and ok != 1: 
    print '<html>'
    print ' <body>'
    print "  <h1>Has introduit malament els parametres, si-us-plau torna'ls ha introduir</h1>"
    print "  <h2>Recorda que el descompte ha d'anar amb punt</h2>"
    print ' <head>'
    print '  <a href="%s">Tornar a introduir el cotxe</a>' % new
    print ' </head>'
    print '</body>'
    print '</html>'
    ok = 1
  	
else:
    if des == 0.0: cost = cost * days * units
    elif des == 1.0: cost = 0
    else: cost = cost * des * days * units
    print '<html>'
    print  '<body>'
    print ' <h2>Has introduit el cotxe perfectament</h2>'
    print ' <h2>Cost del servei % s $</h2>' % cost
    print ' <h2>Per llogar % s cotxe/s % s i % s durant % s dia/es amb el descompte del % s</h2' % (units, model_vehicle, engine, days, des)
    print '   <head>'
    print '     <a href="%s">Home</a>' % home
    print '   </head>'
    print ' </body>'
    print '</html>'
    c = csv.writer(open("car.csv","a"))
    c.writerow([model_vehicle, engine, days, units, des, cost])


