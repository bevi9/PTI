#! /usr/bin/python

# Llibreries
import cgi, os, re, sys, string, time, csv

# Programa principal
print "Content-type: text/html\n\n"

rownum = 0

c = csv.reader(open('car.csv', 'rb'))
print '<table>'
for row in c:
	if rownum == 0:
		print '<tr>'
		for column in row:
			print '<th> % s </th>' % column
		print '</tr>'

	else:
		print '<tr>'
		for column in row:
			print '<td> % s </td>' % column
		print '</tr>'

	rownum += 1

print '</table'



