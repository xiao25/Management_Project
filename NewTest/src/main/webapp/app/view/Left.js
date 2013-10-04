Ext.define('HT.view.Left',
    {
        extend: 'Ext.tree.Panel',
        title: '�˵�',
        alias: 'widget.lefttree',
        region: 'west',
        width: 200,
        height: 300,
        rootVisible: true,
        root: {
            text: '��һ��',
            expanded: true,
            children: [
                {
                    text: '��һ��',
                    leaf: false,
                    children: {
                        text: '��һ��',
                        leaf: true
                    }
                },
                {
                    text: '�ڶ���',
                    leaf: false,
                    children: {
                        text: '��һ��',
                        leaf: true
                    }
                }
            ]
        },
        initComponent: function () {
            this.callParent(arguments);
        }
    }
);