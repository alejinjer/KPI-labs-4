import numpy as np
import pylab as plt
from scipy.signal import argrelextrema
import math

def f(x):
	return x / np.log10(x)

# VIEW A TABLE
a = 0
b = 20
h = 0.2
x = np.arange(a, b + h, h)
y = [f(x[i]) for i in range(len(x))]
table = [[x[i], y[i]] for i in range(len(x))]

for elem in table:
	if elem[0] != 1: print("| x = %.1f" %elem[0] + " | " + "f(x) = %.5f" %elem[1] + " |")

plt.plot(x, y)
plt.show()