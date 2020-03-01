class MyCircularDeque(object):

    def __init__(self, k):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        :type k: int
        """
        self.head = 0
        self.tail = 0
        self.data = [-1]*k
        self.size = 0
        self.capcity = k


    def insertFront(self, value):
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False

        if not self.isEmpty():
            self.head = (self.head + self.capcity - 1) % self.capcity

        self.data[self.head] = value
        self.size += 1

        return True



    def insertLast(self, value):
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """

        if self.isFull():
            return False

        if not self.isEmpty():
            self.tail = (self.tail + 1) % self.capcity

        self.data[self.tail] = value
        self.size += 1

        return True

    def deleteFront(self):
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if self.isEmpty():
            return False

        self.data[self.head] = -1
        self.size -= 1

        if not self.isEmpty():
            self.head = (self.head + 1) % self.capcity


        return True


    def deleteLast(self):
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        :rtype: bool
        """

        if self.isEmpty():
            return False

        self.data[self.tail] = -1
        self.size -= 1

        if not self.isEmpty():
            self.tail = (self.tail + self.capcity - 1) % self.capcity

        return True

    def getFront(self):
        """
        Get the front item from the deque.
        :rtype: int
        """
        if self.isEmpty():
            return  -1

        return  self.data[self.head]


    def getRear(self):
        """
        Get the last item from the deque.
        :rtype: int
        """
        if self.isEmpty():
            return -1

        return  self.data[self.tail]



    def isEmpty(self):
        """
        Checks whether the circular deque is empty or not.
        :rtype: bool
        """

        return self.size == 0


    def isFull(self):
        """
        Checks whether the circular deque is full or not.
        :rtype: bool
        """
        return self.size == self.capcity

