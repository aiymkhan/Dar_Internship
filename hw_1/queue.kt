import java.util.*

class MyQueue() {

    /** Initialize your data structure here. */
    val queue: Stack<Int> = LinkedList<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        queue.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        if(!empty){
          return queue.removeAt(0)
        }
        return null
    }

    /** Get the front element. */
    fun peek(): Int {
        return queue.elementAtOrNull(0)
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return queue.empty()
    }

}


/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
