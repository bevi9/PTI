#! /usr/bin/python

# Llibreries
import cgi, os, re, sys, string, time, csv

# Programa principal
print "Content-type: text/html\n\n"

c = csv.reader(open('car.csv', 'rb'))
for row in c:
	print ', '.join(row)

