package com.hhzmy.bean;

import java.util.List;

/**
 * Created by liyan on 2016/11/9.
 */

public class Pager_Vp
{
    private String api;
    private String code;
    private String msg;
    private String v;
    private int version;
    /**
     * elementShowNumber : 0
     * elementType : 2
     * modelFullCode : 88001
     * modelFullId : 10099
     * modelId : 1781
     * pmodelFullId : 0
     * sequence : 1
     * tag : [{"businessType":"-1","color":"","elementDesc":"","elementName":"11.9","elementType":2,"linkType":4,"linkUrl":"http://c.m.suning.com/channel/myzcqjhyd.html","modelFullId":10099,"picUrl":"/uimg/cms/img/147861667265580841.png","productSpecialFlag":"","sequence":1,"templateFullId":170057,"trickPoint":""},{"businessType":"-1","color":"","elementDesc":"","elementName":"预售","elementType":2,"linkType":4,"linkUrl":"http://c.m.suning.com/channel/ssyysyd.html","modelFullId":10099,"picUrl":"/uimg/cms/img/147792728651688111.jpg","productSpecialFlag":"","sequence":2,"templateFullId":170057,"trickPoint":""},{"businessType":"-1","color":"","elementDesc":"","elementName":"拼购联版","elementType":2,"linkType":4,"linkUrl":"http://c.m.suning.com/RedbabyPg.html","modelFullId":10099,"picUrl":"/uimg/cms/img/147704410779295661.png","productSpecialFlag":"","sequence":4,"templateFullId":170057,"trickPoint":""}]
     */

    private List<DataBean> data;

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int elementShowNumber;
        private int elementType;
        private String modelFullCode;
        private int modelFullId;
        private int modelId;
        private int pmodelFullId;
        private int sequence;
        /**
         * businessType : -1
         * color :
         * elementDesc :
         * elementName : 11.9
         * elementType : 2
         * linkType : 4
         * linkUrl : http://c.m.suning.com/channel/myzcqjhyd.html
         * modelFullId : 10099
         * picUrl : /uimg/cms/img/147861667265580841.png
         * productSpecialFlag :
         * sequence : 1
         * templateFullId : 170057
         * trickPoint :
         */

        private List<TagBean> tag;

        public int getElementShowNumber() {
            return elementShowNumber;
        }

        public void setElementShowNumber(int elementShowNumber) {
            this.elementShowNumber = elementShowNumber;
        }

        public int getElementType() {
            return elementType;
        }

        public void setElementType(int elementType) {
            this.elementType = elementType;
        }

        public String getModelFullCode() {
            return modelFullCode;
        }

        public void setModelFullCode(String modelFullCode) {
            this.modelFullCode = modelFullCode;
        }

        public int getModelFullId() {
            return modelFullId;
        }

        public void setModelFullId(int modelFullId) {
            this.modelFullId = modelFullId;
        }

        public int getModelId() {
            return modelId;
        }

        public void setModelId(int modelId) {
            this.modelId = modelId;
        }

        public int getPmodelFullId() {
            return pmodelFullId;
        }

        public void setPmodelFullId(int pmodelFullId) {
            this.pmodelFullId = pmodelFullId;
        }

        public int getSequence() {
            return sequence;
        }

        public void setSequence(int sequence) {
            this.sequence = sequence;
        }

        public List<TagBean> getTag() {
            return tag;
        }

        public void setTag(List<TagBean> tag) {
            this.tag = tag;
        }

        public static class TagBean {
            private String businessType;
            private String color;
            private String elementDesc;
            private String elementName;
            private int elementType;
            private int linkType;
            private String linkUrl;
            private int modelFullId;
            private String picUrl;
            private String productSpecialFlag;
            private int sequence;
            private int templateFullId;
            private String trickPoint;

            public String getBusinessType() {
                return businessType;
            }

            public void setBusinessType(String businessType) {
                this.businessType = businessType;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getElementDesc() {
                return elementDesc;
            }

            public void setElementDesc(String elementDesc) {
                this.elementDesc = elementDesc;
            }

            public String getElementName() {
                return elementName;
            }

            public void setElementName(String elementName) {
                this.elementName = elementName;
            }

            public int getElementType() {
                return elementType;
            }

            public void setElementType(int elementType) {
                this.elementType = elementType;
            }

            public int getLinkType() {
                return linkType;
            }

            public void setLinkType(int linkType) {
                this.linkType = linkType;
            }

            public String getLinkUrl() {
                return linkUrl;
            }

            public void setLinkUrl(String linkUrl) {
                this.linkUrl = linkUrl;
            }

            public int getModelFullId() {
                return modelFullId;
            }

            public void setModelFullId(int modelFullId) {
                this.modelFullId = modelFullId;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getProductSpecialFlag() {
                return productSpecialFlag;
            }

            public void setProductSpecialFlag(String productSpecialFlag) {
                this.productSpecialFlag = productSpecialFlag;
            }

            public int getSequence() {
                return sequence;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
            }

            public int getTemplateFullId() {
                return templateFullId;
            }

            public void setTemplateFullId(int templateFullId) {
                this.templateFullId = templateFullId;
            }

            public String getTrickPoint() {
                return trickPoint;
            }

            public void setTrickPoint(String trickPoint) {
                this.trickPoint = trickPoint;
            }
        }
    }

}
