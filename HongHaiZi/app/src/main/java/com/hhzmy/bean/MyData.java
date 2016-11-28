package com.hhzmy.bean;

import java.util.List;

/**
 * Created by djx on 2016/11/15.
 */
public class MyData {


    /**
     * elementShowNumber : 0
     * elementType : 2
     * modelFullCode : 88001
     * modelFullId : 10099
     * modelId : 1781
     * pmodelFullId : 0
     * sequence : 1
     * tag : [{"businessType":"-1","color":"","elementDesc":"","elementName":"返场","elementType":2,"linkType":4,"linkUrl":"http://c.m.suning.com/channel/myfcqjhyd.html","modelFullId":10099,"picUrl":"/uimg/cms/img/147894494764004158.png","productSpecialFlag":"","sequence":1,"templateFullId":170057,"trickPoint":""},{"businessType":"-1","color":"","elementDesc":"","elementName":"怡恩贝","elementType":2,"linkType":4,"linkUrl":"http://shop.m.suning.com/70092228.html","modelFullId":10099,"picUrl":"/uimg/cms/img/147884585000874489.jpg","productSpecialFlag":"","sequence":3,"templateFullId":170057,"trickPoint":""},{"businessType":"-1","color":"","elementDesc":"","elementName":"拼购联版","elementType":2,"linkType":4,"linkUrl":"http://c.m.suning.com/RedbabyPg.html","modelFullId":10099,"picUrl":"/uimg/cms/img/147704410779295661.png","productSpecialFlag":"","sequence":4,"templateFullId":170057,"trickPoint":""},{"businessType":"-1","color":"","elementDesc":"","elementName":"试用联版","elementType":2,"linkType":4,"linkUrl":"http://try.m.suning.com/mianfei_muying/now/list.htm","modelFullId":10099,"picUrl":"/uimg/cms/img/147877125414433459.jpg","productSpecialFlag":"","sequence":6,"templateFullId":170057,"trickPoint":""},{"businessType":"-1","color":"","elementDesc":"","elementName":"易付宝联版","elementType":2,"linkType":4,"linkUrl":"http://respay.suning.com/eppClientApp/html/downloadurl/index.html","modelFullId":10099,"picUrl":"/uimg/cms/img/147919140316116549.jpg","productSpecialFlag":"","sequence":7,"templateFullId":170057,"trickPoint":""}]
     */

    public List<DataBean> data;

    public static class DataBean {
        public int elementShowNumber;
        public int elementType;
        public String modelFullCode;
        public int modelFullId;
        public int modelId;
        public int pmodelFullId;
        public int sequence;
        /**
         * businessType : -1
         * color :
         * elementDesc :
         * elementName : 返场
         * elementType : 2
         * linkType : 4
         * linkUrl : http://c.m.suning.com/channel/myfcqjhyd.html
         * modelFullId : 10099
         * picUrl : /uimg/cms/img/147894494764004158.png
         * productSpecialFlag :
         * sequence : 1
         * templateFullId : 170057
         * trickPoint :
         */

        public List<TagBean> tag;

        public static class TagBean {
            public String businessType;
            public String color;
            public String elementDesc;
            public String elementName;
            public int elementType;
            public int linkType;
            public String linkUrl;
            public int modelFullId;
            public String picUrl;
            public String productSpecialFlag;
            public int sequence;
            public int templateFullId;
            public String trickPoint;
        }
    }
}
