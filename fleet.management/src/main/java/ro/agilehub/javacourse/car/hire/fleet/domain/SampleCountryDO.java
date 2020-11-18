package ro.agilehub.javacourse.car.hire.fleet.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SampleCountryDO {

    private String id;

    private String name;

    private String isoCode;

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

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SampleCountryDO that = (SampleCountryDO) o;

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

    public static class SampleCountryDOBuilder {

        private String id;

        private String name;

        private String isoCode;

        public SampleCountryDOBuilder id(String id) {
            this.id = id;
            return this;
        }

        public SampleCountryDOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SampleCountryDOBuilder isoCode(String isoCode) {
            this.isoCode = isoCode;
            return this;
        }

        public SampleCountryDO build() {
            var sampleCountryDO = new SampleCountryDO();
            sampleCountryDO.setId(id);
            sampleCountryDO.setName(name);
            sampleCountryDO.setIsoCode(isoCode);
            return sampleCountryDO;
        }
    }
}
