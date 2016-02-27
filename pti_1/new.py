#!/usr/bin/python
# -*- encoding: utf-8 -*-

# Llibreries
import cgi, os, re, sys, string, time, csv

# Programa principal
print "Content-type: text/html\n\n"

home = "http://localhost/p1/carrental_home.html"
new = "http://localhost/p1/carrental_form_new.html"

c = csv.writer(open("car.csv","a+"))
form = cgi.FieldStorage()
model_vehicle = form.getvalue('model_vehicle')
if model_vehicle == "54":
	 model_vehicle = "Econòmic"
elif model_vehicle == "71": 
	model_vehicle = "Semi-luxe"
elif model_vehicle == "82":
	 model_vehicle = "Luxe"
elif model_vehicle == "139":
	 model_vehicle = "Limusina"

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

if (days <= 0 or des <= 0 or units <= 0 or (des).is_integer() or des > 1) and ok != 1: 
    print '<html>'
    print ' <body>'
    print "  <h1>Has introduit malament els parametres, siusplau torne'ls ha intruduir</h1>"
    print "  <h2>Recorda que el descompte ha d'anar amb punt</h2>"
    print ' <head>'
    print '  <a href="%s">Tornar a introduir el cotxe</a>' % new
    print ' </head>'
    print '</body>'
    print '</html>'
    ok = 1
  	
else:
    print '<html>'
    print  '<body>'
    print ' <h1>Has introduit el cotxe perfectament</h1>'
    print '   <head>'
    print '     <meta http-equiv="refresh" content="3;url=%s" />' % home
    print "     <h3>Redirigint a la pagina d'inici</h3>"
    print '   </head>'
    print ' </body>'
    print '</html>'
    c.writerow([model_vehicle,engine,days,units,des])


