package com.jackshenorion.thinkinjava.designpattern.command.basiccommand;

/**
 * Created by jack on 26/05/2017.
 */
public class Invoker {
    /**
     * 1 个人认为, Invoker内部怎么保存Command并非一定如此,说不定是一个list,优先队列,等等。
     * 因此,Invoker的构造方法也并非一定接受Command作为参数,而可以提供其它方法用于接受新的命令。
     * 2 我们可以注意到, 接受命令和执行命令是分开的,这个是命令模式的另外一个功能,它把接受命令和执行命令在时间上也分开了。
     * 发送命令和发起执行命令可以是不同的客户端。比如执行命令可以是独立的线程。
     */
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
