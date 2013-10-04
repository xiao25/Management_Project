Ext.define('HT.view.Center', {
        extend: 'Ext.tab.Panel',
        layout: 'border',
        //ע�� ����widget.
        alias: 'widget.center',
        region: 'center',
        deferredRender: false,
        activeTab: 0,
        //autoDestroy:false,
        items: [
            {
                title: '欢迎使用',
                html: '首页'
            }
        ],


        initComponent: function () {
            this.callParent(arguments);
        }
    }
);


