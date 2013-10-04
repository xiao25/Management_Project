Ext.define('HT.view.Accordion', {
    extend: 'Ext.panel.Panel',
    title: '操作菜单',
    alias: 'widget.accordion',
    collapsible: true,
    split: true,
    width: 200,
    layout: 'accordion',
    region: 'west',
    layoutConfig: {
        titleCollapse: true,
        animate: true,
        activeOnTop: true
    },
    items: [
        {
            title: '学生信息',
            items: [
                {
                    xtype: 'button',
                    width: 150,
                    name: 'Oeration_stu',
                    text: '学生信息信息操作'
                }


            ]
        },
        {
            title: '课程信息',
            items: [
                {
                    xtype: 'button',
                    width: 150,

                    name: 'ope_cur',
                    text: '课程信息处理'
                }


            ]
        } ,


        {
            title: '成绩信息',
            items: [
                {
                    xtype: 'button',
                    width: 150,
                    name: 'stuinq_grd',
                    text: '学生姓名查询'
                },
                {
                    xtype: 'button',
                    width: 150,
                    name: 'operation_grd',
                    text: '信息基本操作'
                },
                {
                    xtype: 'button',
                    width: 150,
                    name: 'inqcurname_grd',
                    text: '课程名称查询'
                },



            ]
        }
    ]

});


//new try
//Ext.define('HT.view.Accordion', {
//    extend: 'Ext.tree.Panel',
//    title: '操作菜单',
//    alias: 'widget.accordion',
//    rootVisible: false,
//    width: 200,
//
//    region: 'west',
//
//    store: Ext.create('Ext.data.TreeStore', {
//        root: {
//            expanded: true,
//            children: [
//                {
//                    text: '学生信息',
//                    expanded: true,
//                    children: [
//                        {
//
//                            name: 'Oeration_stu',
//                            text: '学生信息信息操作',
//                            leaf: true
//                        }
//
//
//                    ]
//                },
//                {
//                    text: '课程信息',
//                    expanded: true,
//                    children: [
//                        {
//
//                            leaf: true,
//                            name: 'ope_cur',
//                            text: '课程信息处理'
//                        }
//
//
//                    ]
//                } ,
//
//
//                {
//                    text: '成绩信息',
//
//
//                    expanded: true,
//                    children: [
//                        {
//                            leaf: true,
//                            name: 'stuinq_grd',
//                            text: '学生姓名查询'
//                        },
//                        {
//                            leaf: true,
//                            name: 'operation_grd',
//                            text: '信息基本操作'
//                        },
//                        {
//                            leaf: true,
//                            name: 'inqcurname_grd',
//                            text: '课程名称查询'
//                        }
//
//
//                    ]
//                }
//            ]
//        }
//    }),
//    renderTo: Ext.getBody()
//
//});