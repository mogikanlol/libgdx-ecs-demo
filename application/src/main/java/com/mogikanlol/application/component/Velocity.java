package com.mogikanlol.application.component;

public class Velocity extends Component {

    private float x;
    private float y;

    private boolean grounded;

    public Velocity() {

    }

    public Velocity(float x, float y) {
        this.x = x;
        this.y = y;
        grounded = false;
    }

    public boolean isGrounded() {
        return grounded;
    }

    public void setGrounded(boolean grounded) {
        this.grounded = grounded;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
