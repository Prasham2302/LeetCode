class Solution {
    public String convertDateToBinary(String date) {
        String[] info = date.split("-");
        StringBuilder str = new StringBuilder();
        str.append(Integer.toBinaryString(Integer.parseInt(info[0])));
        str.append("-");
        str.append(Integer.toBinaryString(Integer.parseInt(info[1])));
        str.append("-");
        str.append(Integer.toBinaryString(Integer.parseInt(info[2])));
        return str.toString();
    }
}