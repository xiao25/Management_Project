Ext.Loader.setConfig({enabled: true});
Ext.application({
        name: 'HT',
        appFolder: 'app',

        controllers: [
            'StudentController',
            'CourseController',
            'GradeControllers'

        ],
        launch: function () {

            Ext.create('Ext.container.Viewport', {

                layout: 'border',
                items: [
//                    Ext.create("HT.view.Top") ,
//                    Ext.create("HT.view.Accordion"),
//                    Ext.create("HT.view.Center"),
//                    Ext.create("HT.view.Bottom")
                    {
                        xtype: 'top'
                    },
                    {
                        xtype: 'accordion'
                    },
                    {
                        xtype: 'center'
                    },
                    {
                        xtype: 'bottom'
                    }
                ]
            });
        }

    }
);