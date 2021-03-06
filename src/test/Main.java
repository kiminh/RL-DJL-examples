package test;

import ai.djl.engine.Engine;
import main.agent.A2C;
import main.agent.DQN;
import main.agent.DynaQ;
import main.env.Environment;
import main.env.cartpole.CartPole;
import main.utils.Runner;

public class Main {
    public static void main(String[] args) {
        Engine.getInstance().setRandomSeed(0);
        Environment env = new CartPole(false);
        env.seed(0);
        runA2C(env, 500);
    }

    public static void runDynaQ(Environment env, int goal) {
        new Runner(new DynaQ(env.getStateSpace(), 8, 2, 0.1f, 0.95f, 0.05f, 8), env).run(goal);
    }

    public static void runDQN(Environment env, int goal) {
        new Runner(new DQN(env.DimOfStateSpace(), env.NumOfActions(), 64, 32, 32, 0.99f, 0.001f), env).run(goal);
    }

    public static void runA2C(Environment env, int goal) {
        new Runner(new A2C(env.DimOfStateSpace(), env.NumOfActions(), 64, 0.95f, 0.001f), env).run(goal);
    }

    public static void runQRDQM(Environment env, int goal) {
        // new Runner(new QRDQN(env.DimOfStateSpace(), env.NumOfActions(), 16, 64, 256,
        // 8, 0.95f, 0.001f), env).run(goal);
    }
}
