import random

a = []
for i in range(int(random.uniform(5,30))):
    a.append(int(random.uniform(1, 130)))

print(a)

even = 0
odd = 0

for i in a:
    if i%2 == 0:
        even += 1
    else:
        odd += 1

print("Even:", even)
print("Odd:", odd)