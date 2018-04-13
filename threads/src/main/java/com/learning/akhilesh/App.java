
package com.learning.akhilesh;

public class App 
{
    public void printAllThreadGroups() {
        ThreadGroup group = getRootThreadGroup(Thread.currentThread().getThreadGroup());
        group.list();
    }

    private ThreadGroup getRootThreadGroup(final ThreadGroup group) {
        if (group.getParent() == null) {
            return group;
        } else {
            return getRootThreadGroup(group.getParent());
        }
    }
}
