
package swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import menu.EventMenu;
import menu.EventMenuSelected;
import menu.EventShowPopupMenu;
import menu.MenuAnimation;
import menu.MenuItem;
import menu.ModelMenu;
import menu.ScrollBarCustom;
import net.miginfocom.swing.MigLayout;

public class Menu extends javax.swing.JPanel {
    
    public boolean isShowMenu() {
        return showMenu;
    }
    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }


    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }
    public void addEventShow(EventShowPopupMenu eventShow) {
        this.eventShow = eventShow;
    }
    
    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShow;
    private boolean enableMenu = true;
    private boolean showMenu = true;

    
    
    public Menu() {
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setViewportBorder(null);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout=new MigLayout("wrap, fillx, insets 0","[fill]","[]0[]");
        panel.setLayout(layout);
        
    }
    public void initMenuItem(){
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/images/listFood.png")),"Quản Lí Thực Đơn","Danh Mục","Món Ăn"));
//        
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/images/billOrder.png")),"Quản Lí Bàn & Gọi Món","Bàn","Đặt Món","Hóa Đơn"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/images/icons8-analytics-24.png")),"Thống Kê","Doanh Thu ","Số Lượng Món Bán Ra Theo Ngày"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/images/settingMenu.png")),"Quản Lí Chung","Trang Chủ","Nhân Viên","Đổi Mật Khẩu","Đăng Xuất","Thoát"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")),""));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")),""));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("")),""));


//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/images/Anchor.png")),"DanhSach","DanhMuc","MonAn"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/images/Bluetooth.png")),"CaiDat","DoiMatKhau","DangXuat"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/images/Anchor.png")),"DanhSach","DanhMuc","MonAn"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/images/Bluetng")),"CaiDat","DoiMatKhau","DangXuat"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/images/Anchor.png")),"DanhSach","DanhMuc","MonAn"));
//        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/images/Bluetooth.png")),"CaiDat","DoiMatKhau","DangXuat"));
    }
    private void addMenu(ModelMenu menu){
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()),"h 40!");
    }
    private EventMenu getEventMenu(){
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if(enableMenu){
                    if(showMenu){
                        if(open){
                            new MenuAnimation(layout,com).openMenu();
                        }else{
                            new MenuAnimation(layout,com).closeMenu();
                        }
                        return true;
                    }else{
                        eventShow.showPopup(com);
                    }
                }
                return false;
            }
        };
    }
    public void hideallMenu(){
        for(Component com: panel.getComponents()){
            MenuItem item = (MenuItem) com;
            if(item.isOpen()){
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        profile2 = new swing.Profile();

        sp.setBackground(new java.awt.Color(204, 255, 204));
        sp.setBorder(null);
        sp.setForeground(new java.awt.Color(0, 0, 0));
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
            .addComponent(profile2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(profile2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 =(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(153, 153, 255), getWidth(), 0, new Color(153, 0, 204));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g); 
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private swing.Profile profile2;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
