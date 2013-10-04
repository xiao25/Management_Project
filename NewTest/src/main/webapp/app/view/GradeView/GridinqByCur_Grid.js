/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/12/13
 * Time: 6:13 PM
 * To change this template use File | Settings | File Templates.
 */
/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/24/13
 * Time: 9:09 AM
 * To change this template use File | Settings | File Templates.
 */



Ext.define("HT.view.GradeView.GridinqByCur_Grid", {
    extend: "Ext.grid.GridPanel",

    alias: "widget.GridinqByCur_Grid",
    store: 'InquCur',
    region: 'center',


    dockedItems: [
        {
            xtype: 'pagingtoolbar',
            id: 'pagebar',
            store: "InquCur",   // same store GridPanel is using
            dock: 'bottom',
            displayInfo: true,
            displayMsg: '显示第 {0} 条到 {1} 条记录，一共 {2} 条',
            emptyMsg: "没有记录"

        }
    ],
    initComponent: function () {


        items = [



            this.columns = [

                {header: "学号",
                    width: 100,
                    sortable: true,
                    dataIndex: 'stuid'
                } ,


                {header: "姓名",
                    width: 100,
                    sortable: true,
                    dataIndex: 'stuname'
                },
                {header: "班级",
                    width: 100,
                    sortable: true,
                    dataIndex: 'classnum'
                }  ,
                {header: "成绩",
                    width: 100,
                    sortable: true,
                    dataIndex: 'grade'

                },


                {
                    xtype: 'rownumberer',
                    header: '名次',
                    width: 100
                }

            ]




        ];


        this.callParent(arguments);
    }
});


