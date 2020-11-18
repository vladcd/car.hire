package ro.agilehub.javacourse.car.hire.fleet.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SampleEntityDO {

    private String id;

    private String name;

    private SampleCountryDO country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SampleCountryDO getCountry() {
        return country;
    }

    public void setCountry(SampleCountryDO country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SampleEntityDO that = (SampleEntityDO) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    public static class SampleEntityDOBuilder {

        private String id;

        private String name;

        private SampleCountryDO country;

        public SampleEntityDOBuilder id(String id) {
            this.id = id;
            return this;
        }

        public SampleEntityDOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SampleEntityDOBuilder country(SampleCountryDO country) {
            this.country = country;
            return this;
        }

        public SampleEntityDO build() {
            SampleEntityDO sampleEntityDO = new SampleEntityDO();
            sampleEntityDO.setId(id);
            sampleEntityDO.setName(name);
            sampleEntityDO.setCountry(country);
            return sampleEntityDO;
        }
    }
}
