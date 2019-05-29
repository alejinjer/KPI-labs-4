from tkinter import *
import random
root = Tk()

class App:

    def __init__(self, master):
        frame = Frame(master)
        frame.pack()

        self.length1 = Scale(root, from_=5, to_=30, orient=HORIZONTAL)
        self.length1.pack()
        self.length2 = Scale(root, from_=5, to_=30, orient=HORIZONTAL)
        self.length2.pack()
        self.range1 = Scale(root, from_=1, to_=130, orient=HORIZONTAL)
        self.range1.pack()
        self.range2 = Scale(root, from_=1, to_=130, orient=HORIZONTAL)
        self.range2.pack()

        self.f = Button(frame, text="Click me!", command=self.f)
        self.f.pack()        

    def f(self):
        arr = []        
        for i in range(int(random.uniform(self.length1.get(), self.length2.get()))):
            arr.append(int(random.uniform(self.range1.get(), self.range2.get())))

        even = 0
        odd = 0

        for i in arr:
            if i % 2 == 0:
                even += 1
            else:
                odd += 1

        self.result = Label(root, text = arr)
        self.result.pack()

        self.even = Label(root, text = "Even: " + str(even))
        self.even.pack()

        self.odd = Label(root, text = "Odd: " + str(odd))
        self.odd.pack()

app = App(root)

root.mainloop()