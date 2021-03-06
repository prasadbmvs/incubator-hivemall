/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package hivemall.model;

import javax.annotation.Nonnegative;

public class WeightValue implements IWeightValue {

    protected float value;
    protected boolean touched;

    public WeightValue() {}

    public WeightValue(float weight) {
        this(weight, true);
    }

    public WeightValue(float weight, boolean touched) {
        this.value = weight;
        this.touched = touched;
    }

    @Override
    public WeightValueType getType() {
        return WeightValueType.NoParams;
    }

    @Override
    public float getFloatParams(@Nonnegative int i) {
        throw new UnsupportedOperationException("getFloatParams(int) should not be called");
    }

    @Override
    public final float get() {
        return value;
    }

    @Override
    public final void set(float weight) {
        this.value = weight;
    }

    @Override
    public boolean hasCovariance() {
        return false;
    }

    @Override
    public float getCovariance() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCovariance(float cov) {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getSumOfSquaredGradients() {
        return 0.f;
    }

    @Override
    public void setSumOfSquaredGradients(float value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getSumOfSquaredDeltaX() {
        return 0.f;
    }

    @Override
    public void setSumOfSquaredDeltaX(float value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getSumOfGradients() {
        return 0.f;
    }

    @Override
    public void setSumOfGradients(float value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getM() {
        return 0.f;
    }

    @Override
    public void setM(float value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public float getV() {
        return 0.f;
    }

    @Override
    public void setV(float value) {
        throw new UnsupportedOperationException();
    }

    /**
     * @return whether touched in training or not
     */
    @Override
    public final boolean isTouched() {
        return touched;
    }

    @Override
    public final void setTouched(boolean touched) {
        this.touched = touched;
    }

    @Override
    public final short getClock() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void setClock(short clock) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final byte getDeltaUpdates() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void setDeltaUpdates(byte deltaUpdates) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void copyTo(IWeightValue another) {
        another.set(value);
        another.setTouched(touched);
    }

    @Override
    public void copyFrom(IWeightValue another) {
        this.value = another.get();
        this.touched = another.isTouched();
    }

    @Override
    public String toString() {
        return "WeightValue [value=" + value + "]";
    }

    public static final class WeightValueParamsF1 extends WeightValue {
        private float f1;

        public WeightValueParamsF1(float weight, float f1) {
            super(weight);
            this.f1 = f1;
        }

        @Override
        public WeightValueType getType() {
            return WeightValueType.ParamsF1;
        }

        @Override
        public float getFloatParams(@Nonnegative final int i) {
            if (i == 1) {
                return f1;
            }
            throw new IllegalArgumentException("getFloatParams(" + i + ") should not be called");
        }

        @Override
        public final float getSumOfSquaredGradients() {
            return f1;
        }

        @Override
        public void setSumOfSquaredGradients(float value) {
            this.f1 = value;
        }

    }

    /**
     * WeightValue with Sum of Squared Gradients
     */
    public static final class WeightValueParamsF2 extends WeightValue {
        private float f1;
        private float f2;

        public WeightValueParamsF2(float weight, float f1, float f2) {
            super(weight);
            this.f1 = f1;
            this.f2 = f2;
        }

        @Override
        public WeightValueType getType() {
            return WeightValueType.ParamsF2;
        }

        @Override
        public float getFloatParams(@Nonnegative final int i) {
            if (i == 1) {
                return f1;
            } else if (i == 2) {
                return f2;
            }
            throw new IllegalArgumentException("getFloatParams(" + i + ") should not be called");
        }

        @Override
        public final float getSumOfSquaredGradients() {
            return f1;
        }

        @Override
        public void setSumOfSquaredGradients(float value) {
            this.f1 = value;
        }

        @Override
        public final float getSumOfSquaredDeltaX() {
            return f2;
        }

        @Override
        public void setSumOfSquaredDeltaX(float value) {
            this.f2 = value;
        }

        @Override
        public float getSumOfGradients() {
            return f2;
        }

        @Override
        public void setSumOfGradients(float value) {
            this.f2 = value;
        }

        @Override
        public float getM() {
            return f1;
        }

        @Override
        public void setM(float value) {
            this.f1 = value;
        }

        @Override
        public float getV() {
            return f2;
        }

        @Override
        public void setV(float value) {
            this.f2 = value;
        }

    }

    public static final class WeightValueParamsF3 extends WeightValue {
        private float f1;
        private float f2;
        private float f3;

        public WeightValueParamsF3(float weight, float f1, float f2, float f3) {
            super(weight);
            this.f1 = f1;
            this.f2 = f2;
            this.f3 = f3;
        }

        @Override
        public WeightValueType getType() {
            return WeightValueType.ParamsF3;
        }

        @Override
        public float getFloatParams(@Nonnegative final int i) {
            if (i == 1) {
                return f1;
            } else if (i == 2) {
                return f2;
            } else if (i == 3) {
                return f3;
            }
            throw new IllegalArgumentException("getFloatParams(" + i + ") should not be called");
        }

        @Override
        public final float getSumOfSquaredGradients() {
            return f1;
        }

        @Override
        public void setSumOfSquaredGradients(float value) {
            this.f1 = value;
        }

        @Override
        public final float getSumOfSquaredDeltaX() {
            return f2;
        }

        @Override
        public void setSumOfSquaredDeltaX(float value) {
            this.f2 = value;
        }

        @Override
        public float getSumOfGradients() {
            return f3;
        }

        @Override
        public void setSumOfGradients(float value) {
            this.f3 = value;
        }

        @Override
        public float getM() {
            return f1;
        }

        @Override
        public void setM(float value) {
            this.f1 = value;
        }

        @Override
        public float getV() {
            return f2;
        }

        @Override
        public void setV(float value) {
            this.f2 = value;
        }

    }

    public static final class WeightValueWithCovar extends WeightValue {
        public static final float DEFAULT_COVAR = 1.f;

        private float covariance;

        public WeightValueWithCovar() {
            super();
        }

        public WeightValueWithCovar(float weight, float covariance) {
            this(weight, covariance, true);
        }

        public WeightValueWithCovar(float weight, float covariance, boolean touched) {
            super(weight, touched);
            this.covariance = covariance;
        }

        @Override
        public WeightValueType getType() {
            return WeightValueType.ParamsCovar;
        }

        @Override
        public boolean hasCovariance() {
            return true;
        }

        @Override
        public float getCovariance() {
            return covariance;
        }

        @Override
        public void setCovariance(float cov) {
            this.covariance = cov;
        }

        @Override
        public void copyTo(IWeightValue another) {
            super.copyTo(another);
            another.setCovariance(covariance);
        }

        @Override
        public void copyFrom(IWeightValue another) {
            super.copyFrom(another);
            this.covariance = another.getCovariance();
        }

        @Override
        public String toString() {
            return "WeightValueWithCovar [value=" + value + ", covariance=" + covariance + "]";
        }
    }

}
