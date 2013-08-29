#! /usr/bin/env python

import sys
import util
input_file = open(sys.argv[1], 'r')
base = int(input_file.readline()) # Get the base weight
line = input_file.readline()
edges = [] # Store the edges from the input file in a list
distance = 0 # The distance the bird needs to travel
print "Begin Parsing Input File"
while line:
  nums = line.split() # [start, end, weight]
  num1 = int(nums[1])
  distance = max(num1, distance) # Keep track of the maximum travel distance
  edges.append((int(nums[0]), num1, int(nums[2])))
  line = input_file.readline()
input_file.close()
print "Finished Parsing Input File"
print "Begin Sorting Edges"
edges.sort(key = lambda value: value[2])
print "Finished Sorting Edges"
