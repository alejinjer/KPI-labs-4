class Plane:
    seats = []
    def __init__(self, type, capacity):
        self.type = type
        self.capacity = capacity     
        print(""" 
           _
         -=\`\\
     |\ ____\_\__
   -=\c`\"\"\"\"\"\"\" "`)
      `~~~~~/ /~~`
        -==/ /
          '-'\n""" + "\n\t" + self.type + ", Capacity: " + str(self.capacity) + "\n")  

    def addPassenger(self, Passenger):
        if not self.seats.__contains__(Passenger) and len(self.seats) < self.capacity:
            self.seats.append(Passenger)
            print("Passenger " + Passenger.name + " has succesfully sat down.")
        elif self.seats.__contains__(Passenger):
            print("This passenger is already sitting!")
        else: print("Plane is overflow!")


    def showCountOfPassengers(self):
        n = 0
        for p in self.seats:
            n += 1
        return n
    
class Gate:
    parking = []
    def addPlane(self, Plane):
        if not self.parking.__contains__(Plane):
            self.parking.append(Plane)
            print("Plane " + Plane.type + " has succesfully parked.")
        else:
            print("This plane is already parked!")

class Passenger:
    def __init__(self, name):
        self.name = name

gate = Gate()
plane = Plane("\"Boeing 737\"", 4)
arr = [
    Passenger("Kolya"),
    Passenger("Sanya"),
    Passenger("Maks"),
    Passenger("Leha"),
    Passenger("Vasya"),
    Passenger("Petya")
]
for p in arr:
    plane.addPassenger(p)

plane.addPassenger(arr[0])

gate.addPlane(plane)
gate.addPlane(plane)