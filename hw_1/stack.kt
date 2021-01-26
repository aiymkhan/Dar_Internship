import java.util.*
class MyStack() {

    /** Initialize your data structure here. */
    val stack: Queue<Int> = LinkedList<Int>()


    /** Push element x onto stack. */
    fun push(x: Int) {
        stack.add(x)
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        if(!stack.empty())
          return removeAt(stack.size -1)
        return null
    }

    /** Get the top element. */
    fun top(): Int {
        return stack.lastOrNull()
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return stack.empty()
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
