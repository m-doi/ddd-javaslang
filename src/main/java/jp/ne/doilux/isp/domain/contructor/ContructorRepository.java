package jp.ne.doilux.isp.domain.contructor;


import javaslang.control.Option;

public interface ContructorRepository {

    Option<Contractor> find(jp.ne.doilux.isp.domain.applicant.Name name);

    void save(Contractor contractor);
}
