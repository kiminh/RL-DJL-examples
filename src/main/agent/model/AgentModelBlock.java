package main.agent.model;

import ai.djl.ndarray.NDManager;
import ai.djl.nn.AbstractBlock;

public abstract class AgentModelBlock extends AbstractBlock {
    private static final byte VERSION = 2;
    private final NDManager manager;

    public AgentModelBlock(NDManager manager) {
        super(VERSION);
        this.manager = manager;
    }

    public NDManager getManager() {
        return manager;
    }

}
