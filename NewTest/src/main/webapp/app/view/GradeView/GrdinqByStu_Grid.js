/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/9/13
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
Ext.define("HT.view.GradeView.GrdinqByStu_Grid", {
    extend: "Ext.grid.GridPanel",
    id: 'GrdinqByStu_Grid',
    alias: "widget.GrdinqByStu_Grid",
    //默认STORE，不然会报错
    // store: 'Grade',


    dockedItems: [
        {
            xtype: 'pagingtoolbar',
            id: 'pagebar1',
            store: "Grade",   // same store GridPanel is using
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
                    sortable: false

                },
                {header: "姓名",
                    width: 100,
                    sortable: false

                }


            ]




        ];

        this.callParent(arguments);


    }

});