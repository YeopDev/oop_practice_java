package io.gitgub.yeop.ladderGame.strategy;

import io.gitgub.yeop.ladderGame.util.RandomUtil;

public class Point implements PointStrategy{
    private static final int POINT_CONDITION = 1;

    @Override
    public boolean isPoint() {
        return (RandomUtil.AUTO.create() == POINT_CONDITION);
    }

    public static Point location(){
        return new Point();
    }
}
