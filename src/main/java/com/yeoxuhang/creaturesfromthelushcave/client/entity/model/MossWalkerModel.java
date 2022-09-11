package com.yeoxuhang.creaturesfromthelushcave.client.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.yeoxuhang.creaturesfromthelushcave.yeoxuhang.MathAddon;
import com.yeoxuhang.creaturesfromthelushcave.entity.MossWalkerEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class MossWalkerModel<T extends MossWalkerEntity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("cftlc", "moss_walker"), "main");
	private final ModelPart root;
	private final ModelPart MossWalker;
	//MossWalker
	private final ModelPart body;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart grass;

	public MossWalkerModel(ModelPart root) {
		this.root = root;
		this.MossWalker = root.getChild("MossWalker");
		//MossWalker
		this.body = MossWalker.getChild("body");

		this.left_leg = MossWalker.getChild("left_leg");
		this.right_leg = MossWalker.getChild("right_leg");
		this.grass = body.getChild("grass");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition MossWalker = partdefinition.addOrReplaceChild("MossWalker", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_leg = MossWalker.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 40).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 29.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, -29.0F, 0.0F));

		PartDefinition right_leg = MossWalker.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(20, 40).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 29.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, -29.0F, 0.0F));

		PartDefinition body = MossWalker.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -20.0F, -10.5F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -29.0F, 0.0F));

		PartDefinition grass = body.addOrReplaceChild("grass", CubeListBuilder.create(), PartPose.offset(0.0F, -20.0F, 0.0F));

		PartDefinition cube_r1 = grass.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(60, 0).addBox(-8.0F, -66.0F, -0.5F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 50.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r2 = grass.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(60, 0).addBox(-8.0F, -66.0F, -0.5F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 50.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float range = limbSwingAmount * 0.3F;
		float amount = 0.1f/(3*(limbSwingAmount) + 1);
		float freq = (ageInTicks) * 0.2f;
		this.right_leg.xRot = Mth.cos(limbSwing * 0.5F) * 0.5F * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 0.5F) * -0.5F * limbSwingAmount;
		this.body.y = -28 + (float)(MathAddon.cutCos(limbSwing * 1, 0, true) * 10 * range);
		this.body.zRot = Mth.cos(limbSwing * 0.5f) * 0.3f * limbSwingAmount;
		this.body.xRot = Mth.cos(limbSwing * 0.5f) * 0.3f * limbSwingAmount;
		this.body.yRot = Mth.cos(limbSwing * 0.5f) * 0.3f * limbSwingAmount;
		this.MossWalker.zRot = Mth.cos(limbSwing * 0.3f) * 0.1f * limbSwingAmount;
		this.MossWalker.xRot = Mth.cos(limbSwing * 0.3f) * 0.1f * limbSwingAmount;
		this.MossWalker.yRot = Mth.cos(limbSwing * 0.3f) * 0.1f * limbSwingAmount;
		this.grass.xRot = (float) Math.cos(freq) * amount + Mth.cos(limbSwing * 0.05F) * 0.1F * limbSwingAmount;
		this.grass.zRot = (float) Math.sin(freq) * amount + Mth.sin(limbSwing * 0.05F) * 0.1F * limbSwingAmount;

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		if (this.young) {
			poseStack.scale(0.6F, 0.6F, 0.6F);
			poseStack.translate(0, 1, 0);
		}
		MossWalker.render(poseStack, buffer, packedLight, packedOverlay);
	}
}